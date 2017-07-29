package service.example.com.testremoteservice;

import android.os.Parcel;
import android.os.Parcelable;



public class Person  implements Parcelable{
    private String name;
    private Pet pet;   //嵌套一个其他类


    protected Person(Parcel in) {
        name = in.readString();
        pet = in.readParcelable(Pet.class.getClassLoader());   //这里增加了对其他序列化类的读取
    }
    public Person(){};
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(pet,flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
