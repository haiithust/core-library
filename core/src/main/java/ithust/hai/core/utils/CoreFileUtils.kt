package ithust.hai.core.utils

import android.content.Context
import android.media.MediaScannerConnection
import android.net.Uri
import androidx.annotation.WorkerThread
import androidx.core.content.FileProvider
import androidx.core.net.toFile
import java.io.FileInputStream
import java.io.InputStream

/**
 * @author conghai on 9/7/20.
 */
object CoreFileUtils {
    const val VIDEO_MIME_TYPE = "video/mp4"
    fun getShareUri(context: Context, uri: Uri): Uri {
        val result = runCatching { uri.toFile() }
        if (result.isSuccess) {
            return FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                result.getOrThrow()
            )
        }
        return uri
    }

    fun getFileLength(context: Context, uri: Uri): Long {
        val result = runCatching { uri.toFile().length() }
        if (result.isSuccess) {
            return result.getOrThrow()
        }
        return runCatching {
            context.contentResolver.openFileDescriptor(uri, "r")?.statSize ?: 0L
        }.getOrDefault(0L)
    }

    @WorkerThread
    fun getInputStream(context: Context, uri: Uri): InputStream? {
        val result = runCatching { FileInputStream(uri.toFile()) }
        if (result.isFailure) {
            runCatching {
                return context.contentResolver.openInputStream(uri)
            }
        }
        return result.getOrNull()
    }

    @WorkerThread
    fun delete(context: Context, uri: Uri) {
        val result = runCatching {
            val file = uri.toFile()
            if (file.delete()) {
                MediaScannerConnection.scanFile(context, arrayOf(file.absolutePath), null, null)
            }
        }
        if (result.isFailure) {
            runCatching {
                context.contentResolver.apply {
                    delete(uri, null, null)
                    notifyChange(uri, null)
                }
            }
        }
    }
}