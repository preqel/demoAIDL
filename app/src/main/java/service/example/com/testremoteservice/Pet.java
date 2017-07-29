package service.example.com.testremoteservice;

import android.os.Parcel;
import android.os.Parcelable;



public class Pet implements Parcelable{

    public Pet (){

    }


    private String petname;

    protected Pet(Parcel in) {
        petname = in.readString();
    }

    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(petname);
    }
}
