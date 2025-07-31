public class Program{
public static void main(String[] args) {
    Animal meuAnimal = new Animal();
    Cachorro meuCachorro = new Cachorro();
    Object obj = meuCachorro;
    Animal umOutroAnimal = meuCachorro; 

    System.err.println("meuAnimal eh um " + meuAnimal.getClass().getName());
    System.err.println("meuCachorro eh um " + meuCachorro.getClass().getName());
    System.err.println("obj eh um " + obj.getClass().getName());
    System.err.println("umOutroAnimal eh um " + umOutroAnimal.getClass().getName());
    }
}