package Test;

import com.lancer.Interface.EmplyeeMapper;
import com.lancer.Interface.TestMapper;
import com.lancer.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    /**
     * 1、根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
     * 2、sql映射文件：配置了每一个sql，以及sql的封装规则等
     * 3、将sql映射文件注册在全局配置文件中
     *
     * 4、写代码：
     *      1)、根据全局配置文件得到SqlSessionFactory；
     *      2)、使用sqlSessionFactory获得sqlSession对象使用它来执行增删改查
     *      一个sqlSession就代表与数据库的一次会话，用完后需要关闭
     *      3）、使用sql的唯一标识来告诉Mybatis执行哪个sql语句，sql都是保存在sql映射文件中的
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取sqlSession实例，能执行已经映射的sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //这里的第一个参数：命名空间.id值，防止不同的命名空间中id 值重复
//            Employee employee = sqlSession.selectOne("com.lancer.bean.Employee.selectEmp", 1);
//            System.out.println(employee);
        }finally {
            sqlSession.close();
        }
    }

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test02() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2、获取sqlSession实例，能执行已经映射的sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            //获得接口的实现类
            //只要将接口与sql映射文件进行绑定，mybatis会自动创建一个代理对象去执行增删改查
            EmplyeeMapper mapper = sqlSession.getMapper(EmplyeeMapper.class);
            System.out.println("=======================================");
            Employee employeeId = mapper.getEmployeeId(1);
            List<Employee> allEmps = mapper.getAllEmps();
            System.out.println("=====================================");
            Employee employeeId1 = mapper.getEmployeeId(1);
            System.out.println("********************************");
            System.out.println(mapper.getClass());

            System.out.println("--------------------------"+employeeId);
            System.out.println(employeeId1);
            System.out.println(allEmps);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            EmplyeeMapper mapper = sqlSession.getMapper(EmplyeeMapper.class);
            Employee employee=new Employee(4,"Jack","123","0");
            mapper.insert(employee);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    //测试mybatis的二级缓存
    @Test
    public void test04() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        EmplyeeMapper mapper = sqlSession.getMapper(EmplyeeMapper.class);
        EmplyeeMapper mapper1 = sqlSession1.getMapper(EmplyeeMapper.class);

        try {
            System.out.println("==================================");
            Employee employeeId = mapper.getEmployeeId(1);
            sqlSession.close();
            System.out.println("**************************");
//            Employee employeeId1 = mapper.getEmployeeId(1);
            Employee employeeId1 = mapper1.getEmployeeId(1);
            System.out.println("===================");

            System.out.println(employeeId1);
            System.out.println(employeeId);
        }finally {
//            sqlSession.close();
            sqlSession1.close();
        }
    }

    //测试mybatis返回Map数据类型
    @Test
    public void test05() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmplyeeMapper mapper = sqlSession.getMapper(EmplyeeMapper.class);
            Map<Integer, Employee> map = mapper.getMap();
            for (Map.Entry<Integer,Employee> entry:map.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }finally {
            sqlSession.close();
        }
    }

    //测试mybatis返回查询部分字段
    @Test
    public void test06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmplyeeMapper mapper = sqlSession.getMapper(EmplyeeMapper.class);
            Employee partEmp = mapper.getPartEmp(1);
            System.out.println(partEmp);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test07() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmplyeeMapper mapper = sqlSession.getMapper(EmplyeeMapper.class);

            Employee employee=new Employee();
//            employee.setId(1);
            employee.setLastName("%T%");

            List<Employee> empsByConditionIf = mapper.getEmpsByConditionIf(employee);

            System.out.println(empsByConditionIf);

            //查询的时候如果某些条件没带，拼装会有问题
            //1、在where后面加上1=1；以后的条件都加上and
            //2、mybatis使用where标签来将所有的查询条件包括在内，where标签只会去掉多出来的第一个and 或者 or

        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void test08() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }


    @Test
    public void test09() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
            com.lancer.bean.Test test = mapper.selectByPrimaryKey(1);
            System.out.println(test);
        }finally {
            sqlSession.close();
        }
    }
}
