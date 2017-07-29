package service.example.com.testremoteservice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wyp on 2017/7/28.
 */

public class Person  implements Parcelable{
    private String name;


    protected Person(Parcel in) {
        name = in.readString();

    }
    public Person(){};
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
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
}
