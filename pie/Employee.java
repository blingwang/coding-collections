import java.util.Comparator;
import java.util.Arrays;

public class Employee{
    public String extension;
    public String givenname;
    public String surname;
    public int sequence;

    public void sortEmployees(Employee[] employees){
        Arrays.sort(employees, new EmployeeNameComparator());
    }

    // a comparator for Employee instance
    public class EmployeeNameComparator implements Comparator<Employee>{
        public int compare(Employee e1, Employee e2){
            // compare surnames
            int ret = e1.surname.compareToIgnoreCase(e2.surname);

            if(ret == 0){// compare givenames if surnames are the same
                ret = e1.givenname.compareToIgnoreCase(e2.givenname);
            }

            return ret;
        }
    }

    public void sortEmployeesStableWithSequence(Employee[] employees){
        for(int i = 0; i < employees.length; ++i){
            employees[i].sequence = i;
        }
        shakySort(employees, new EmployeeSequenceComparator());
    }

    // a comparator for employee instances
    public class EmployeeSequenceComparator implements Comparator<Employee>{
        public int compare(Employee e1, Employee e2){
            // compare surname first
            int ret = e1.surname.compareToIgnoreCase(e2.surname);

            // ensure stability
            if(ret == 0){
                ret = e1.sequence - e2.sequence;
            }

            return ret;
        }
    }

} 
