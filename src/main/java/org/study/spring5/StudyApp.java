package org.study.spring5;

public abstract class StudyApp {

    public static String getXML(Class<?> clazz, String file) {
        String s = clazz.getPackage().getName();
        return s.replace(".", "/")
                .replace("org/study", "") + "/" + file + ".xml";
    }

    public static void log(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

}
