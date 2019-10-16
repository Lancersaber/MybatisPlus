package 第14章类型信息.proxy.myownproxy.MyTest;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String path;

    public MyClassLoader(String path){
        this.path=path;
    }

    //获取要加载 的class文件名
    private String getFileName(String name) {
        // TODO Auto-generated method stub
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String fileName = getFileName(name);
        System.out.println("fileName = "+fileName);

        File file = new File(path,fileName);

        System.out.println(file.getName()+" "+file.getPath());

        FileInputStream inputStream=null;
        ByteArrayOutputStream outputStream=null;

        try {
            inputStream=new FileInputStream(file);
            outputStream=new ByteArrayOutputStream();
            int i=0;
            while ((i=inputStream.read())!=-1){
                outputStream.write(i);
            }
            byte[] bytes = outputStream.toByteArray();

            System.out.println(bytes.length);

            inputStream.close();
            outputStream.close();

            return defineClass(name,bytes,0,bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
