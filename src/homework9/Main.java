package homework9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    private static final String ZIP_ARCHIVE = "/home/marik/Рабочий стол/src.zip";
    private static final int BUFFER = 1024;
    private int count;
    private int annotationCount;
    private List<File> files = new ArrayList<>();

    public static void main(String[] args) {
        Main app = new Main();
        app.unZip();
    }

    private void unZip() {
        byte[] buffer = new byte[BUFFER];
        final String targetDirectory = destinationDirectory();

        try {
            final ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(Main.ZIP_ARCHIVE));
            ZipEntry entry = zipInputStream.getNextEntry();
            String nextFileName;
            while (entry != null) {
                nextFileName = entry.getName();
                File nextFile = new File(targetDirectory + File.separator + nextFileName);
                if (nextFileName.contains(".java")){
                    count++;
                    files.add(nextFile);
                }

                if (entry.isDirectory()) {
                    nextFile.mkdir();
                } else {
                    new File(nextFile.getParent()).mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(nextFile)) {
                        int length;
                        while((length = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                entry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
            System.out.println("marik@mihail ~ $ java -version\n" +
                    "java version \"10.0.1\" 2018-04-17\n" +
                    "Java(TM) SE Runtime Environment 18.3 (build 10.0.1+10)\n" +
                    "Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.1+10, mixed mode)\n");
            System.out.println(count + " java file(s)");
            annotationFiles(files);
            System.out.println(annotationCount + " @FunctionalInterface file(s)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void annotationFiles(List<File> files) throws IOException {
        for (File file : files){
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String string;
            while ((string = reader.readLine()) != null) if (string.equals("@FunctionalInterface")) {
                annotationCount++;
            }
        }
    }

    private String destinationDirectory() {
        return Main.ZIP_ARCHIVE.substring(0, Main.ZIP_ARCHIVE.lastIndexOf("."));
    }
}