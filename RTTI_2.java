//泛型类语法
class CountedInteger{
  private static long counter;
  private final long id = counter++;
  public String toString(){  return Long.toString(id);  }
}

public class FilledList<T>{
  private Class<T> type;
  public FilledList(Class<T> type){
    this.type = type;
  }
  public List<T> create(int nElements){
    List<T> result = new ArrayList<T>();
    try{
      for(int i = 0; i < nElements; i++)
        result.add(type.newInstance());
    }catch(Exception e ){
      throw new RuntimeException(e);
    }
    return result;
  }
  public static void mian(String args[]){
    FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
    system.out.println(fl.create(15));//最终打印result数组，数组中存放的是CountedInteger的具体类型，这是有newInstance()方法确定的
  }
    
}

//通配符-----》  “ ？” 
public class WildcardClassReferences{
  public static void mian(String args[]){
    Class<?> intClass = int.class;//什么类都可以，不进行限定某种类型，==》无范围
    intClass = double.class;
  }
}

//如果要限定某种类型，或者是该类型的某种子类型，需要将extends和通配符关键字相结合，创建一个范围
public class BoundedClassReference{
  public static void mian(String args[]){
    Class<? extends Number> bounded = int.class;
    bounded = double.class;
    bounded = Number.class;
    //or anything else derived from Number
  }
}






































