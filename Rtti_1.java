/**
  java让我们在运行时识别对象和类的信息的主要方式有两种：
    1.传统的RTTI，他假定我们在编译期已经知道所有的类型，比如说多态的类参差结构
    2.反射机制，他允许我们在运行时发现和使用类的信息
**/
//在java中，所有的类型转换都是在运行时进行正确性检查的，RTTI的含义就是，在运行时，识别一个对象的类型
//接下来看一个多态的类层次结构
abstract class Shape{
  void draw(){  system.out.println(this+".draw()");  }
  abstract public String toString();
}

class Circle entends Shape{
  public String toString(){  return "Circle";}
}

class Square entends Shape{
  public String toString(){  return "Square";}
}

class Triangle entends Shape{
  public String toString(){  return "Triangle";}
}

public class Shapes{
  public static void main(String arg[]){
    List<Shape> shapeLsit = Arrays.asList(new Circle(), new Square, new Triangle());
    for(Shape shape : shapeList)
      shape,draw();
  }
}
//Shape中的toString 方法被声明为abstract，以此强制继承者覆写该方法，该例子中,把Shape对象（Cricle等）放入List<Shape>的数组会自动向上转型，但向上转型的时候也会丢失Shape对象的具体类型，对于数组list来说，他们只是shape类的对象
//但是RTTI类型转换的并不彻底，Object转型为Shape，而不是转型为Shape的具体对象，这是因为目前我们只知道这个List<Shape>保存的是Shape，在编译期将由容器和java泛型系统来强制确保这一点，而在运行时由类型转换操作来确保这一点
//接下来就是多态机制的事情了，Shape具体执行什么什么样的代码，是由引用所指向的具体的对象决定的，通常你希望大部分的代码尽可能少的了解对象的具体类型，而是只与对象家族的一个通用表示打交道，这样代码更容易写，更容易读，且更容易维护，设计也更容易实现，理解和改变
