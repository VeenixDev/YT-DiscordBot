package com.youtube.dcbot.misc;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.CodeSource;

public class FileUtils {

    /**
     * Returns the path to the parent file of the compiled .jar file
     *
     * @Author https://stackoverflow.com/users/429873/dmitry-trofimov
     *
     * @param aclass
     * @return
     * @throws URISyntaxException
     * @throws UnsupportedEncodingException
     */
    public static String getJarContainingFolder(Class<?> aclass) throws URISyntaxException, UnsupportedEncodingException {
        CodeSource codeSource = aclass.getProtectionDomain().getCodeSource();

        File jarFile;

        if (codeSource.getLocation() != null) {
            jarFile = new File(codeSource.getLocation().toURI());
        }
        else {
            String path = aclass.getResource(aclass.getSimpleName() + ".class").getPath();
            String jarFilePath = path.substring(path.indexOf(":") + 1, path.indexOf("!"));
            jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
            jarFile = new File(jarFilePath);
        }
        return jarFile.getParentFile().getAbsolutePath();
    }

}
