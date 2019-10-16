package 第14章类型信息.proxy.myownproxy.MyTest;

import javax.tools.*;
import java.net.URI;
import java.util.Arrays;

public class CompilerTest {

    public static void main(String[] args){
        String source="public class Main{ " +
                " public static void main(String[] args){ " +
                "System.out.println(\"Hello World\");}}";
//        System.out.println("Hello World");
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager=compiler.getStandardFileManager(null,null,null);

        StringSourceJavaObject sourceObject=new CompilerTest.StringSourceJavaObject("Main",source);
        Iterable<? extends JavaFileObject> fileObjects= Arrays.asList(sourceObject);
        JavaCompiler.CompilationTask task=compiler.getTask(null,fileManager,null,null,null,fileObjects);
        boolean result=task.call();
        if (result){
            System.out.println("编译成功");
        }
    }

    static class StringSourceJavaObject extends SimpleJavaFileObject{

        private String content=null;
        /**
         * Construct a SimpleJavaFileObject of the given kind and with the
         * given URI.
         *
         * @param uri  the URI for this file object
         * @param kind the kind of this file object
         */
        protected StringSourceJavaObject(URI uri, Kind kind) {
            super(uri, kind);
        }

        public StringSourceJavaObject(String name,String content){
            super(URI.create("string:///"+name.replace('.','/')+Kind.SOURCE.extension),Kind.SOURCE);
            this.content=content;
        }

        public CharSequence getCharContent(boolean ignoreEncodingErrors){
            return content;
        }
    }
}
