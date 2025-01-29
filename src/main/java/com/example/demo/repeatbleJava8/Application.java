package com.example.demo.repeatbleJava8;

@Student(name = "sandeep", address = "Hyd")
@Student(name = "jani", address = "Hyd")
public class Application {
    public static void main(String[] args) {
        Student[] res = Application.class.getAnnotationsByType(Student.class);
        for (Student st : res){
            System.out.println(st.name() +" ,"+ st.address());
        }

    }
}
/* before java8
@Students({
@Student(name = "sandeep", address = "Hyd"),
@Student(name = "jani", address = "Hyd")
})
 */
