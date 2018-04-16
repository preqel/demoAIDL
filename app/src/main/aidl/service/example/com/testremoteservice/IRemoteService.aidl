// IRemoteService.aidl
package service.example.com.testremoteservice;
import service.example.com.testremoteservice.Person;

// Declare any non-default types here with import statements

interface IRemoteService {

    String getInfo();
    Person getPerson();
    String getPersonList(in List<String> lists);
}
