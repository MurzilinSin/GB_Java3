package lesson7;

public class Testing {

    @Test(priority = 10)
    public void test1(){
        System.out.println("Я тест 1. Имею приоритет 10");
    }

    @Test(priority = 5)
    public void test2(){
        System.out.println("Я тест 2. Имею приоритет 5");
    }

    @Test(priority = 8)
    public void test3(){
        System.out.println("Я тест 3. Имею приоритет 8");
    }

    @Test(priority = 2)
    public void test4(){
        System.out.println("Я тест 4. Имею приоритет 2");
    }

    @Test(priority = 5)
    public void test5(){
        System.out.println("Я тест 5. Имею приоритет 5");
    }

    @Test
    public void test6(){
        System.out.println("Я тест 6. Имею дефолтный приоритет");
    }

    @Test
    public void test7(){
        System.out.println("Я тест 7. Имею дефолтный приоритет");
    }

    @BeforeSuite
    public void inception(){
        System.out.println("НАЧАЛО");
    }

    @AfterSuite
    public void end(){System.out.println("Всему приходит конец");}
}
