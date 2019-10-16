package 第14章类型信息.proxy.myownproxy.MyTest;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Test02 {

    public static void main(String[] args) throws FileNotFoundException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        test02();
    }

    public static void test02() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fileName="D:\\Java编程代码\\Thinking in Java\\Hello.java";
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager=compiler.getStandardFileManager(null,null,null);
        Iterable<? extends JavaFileObject> files=fileManager.getJavaFileObjectsFromStrings(Arrays.asList(fileName));
        JavaCompiler.CompilationTask task = compiler.getTask(
                null, fileManager, null, null, null, files);
        Boolean result = task.call();
         if( result == true ) {
              System.out.println("Succeeded");
         }
//         MyClassLoader myClassLoader=new MyClassLoader("D:\\lib");
//        Class<?> aClass = myClassLoader.loadClass("Test");
        DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib");
        Class<?> aClass = diskLoader.loadClass("Test");
        if (aClass!=null){
            Object o = aClass.newInstance();
            System.out.println("成功");
        }
    }

    public static void test() throws FileNotFoundException {
        String fileName="D:\\Java编程代码\\Thinking in Java\\Hello.java";
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        FileOutputStream err = new FileOutputStream("D:\\Java编程代码\\Thinking in Java\\err.txt");

        int compilationResult = compiler.run(null, null, err, fileName);
        if(compilationResult == 0){
            System.out.println("Done");
        } else {
            System.out.println("Fail");
        }
    }
}
