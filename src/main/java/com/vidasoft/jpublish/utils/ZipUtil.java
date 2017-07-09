package com.vidasoft.jpublish.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static void zip(File fileToZip, File target) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(target);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            zipFile(fileToZip, fileToZip.getName(), zos);
        }
    }

    private static void zipFile(File fileToZip, String entryName, ZipOutputStream zos) throws IOException {
        if (fileToZip.isDirectory()) {
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, entryName + "/" + childFile.getName(), zos);
            }
        } else {
            ZipEntry zipEntry = new ZipEntry(entryName);
            zos.putNextEntry(zipEntry);
            try (FileInputStream fis = new FileInputStream(fileToZip)) {
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zos.write(bytes, 0, length);
                }
            }
        }
    }
}
