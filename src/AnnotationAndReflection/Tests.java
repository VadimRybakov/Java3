package AnnotationAndReflection;

public class Tests {
    @Before
    public void init(){
        System.out.println("Start tests");
    }

    @Test()
    public void methodOne(){
        System.out.println("Tests first");
    }

    @Test(priority = 5)
    public void methodTwo(){
        System.out.println("Tests second");
    }

    @Test(priority = 10)
    public void methodThree(){
        System.out.println("Tests last");
    }

    @After
    public void finish(){
        System.out.println("Tests are finished");
    }
}
