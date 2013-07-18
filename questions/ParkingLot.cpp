int test_parking_lots(){
    ParkingLots p(3,40,50);//floor, row, column
    Car car1 = Car();
    Motor motor1 = Motor();
    Bus bus1 = Bus();
    int car1_id, motor1_id, bus1_id; 
    bool res;
    res = p.park(car1, car1_id);
    res = p.park(motor1, motor1_id); 
    res = p.park(bus1, bus1_id); 

    res = p.unpark(car1, car1_id); 
    return 0;
}
typedef enum VehicleType_e{
    MOTOR_VEHICLE_TYPE = 0,
    CAR_VEHICLE_TYPE,
    BUS_VEHICLE_TYPE,
    MAX_VEHICLE_TYPE_SIZE
} VehicleType;
typedef enum SpotType_e{
    INVALID_SPOT_TYPE = -1,
    COMPACT_SPOT_TYPE = 0,
    LARGE_SPOT_TYPE,
    MAX_SPOT_TYPE_SIZE
} SpotType;
typedef enum Needed_Spot_Num_e{
    MOTOR_SPOT_NUM = 1,
    CAR_SPOT_NUM = 1,
    BUS_SPOT_NUM = 5
} Needed_Spot_Num; 

class Vehicle{
public: 
    Vehicle(int num_spots):num_of_spots(num_spots){} 
    virtual void fitted_spot_type() = 0;
    int num_of_spots;//note member variable of base must be assigned at base
class, not subclass.
    bool canPark(SpotType spot_type);//can the vehicle park at this spot_
type
    vector<SpotType> spot_type_list; //supported spot types
};
bool Vehicle::canPark(SpotType spot_type){
        vector<SpotType>::iterator itt; 
        for (itt = spot_type_list.begin(); itt != spot_type_list.end();++itt
){
            if (spot_type == *itt) return true;
        }
        return false;
}

class Car: public Vehicle{
public:
    Car():Vehicle(CAR_SPOT_NUM){fitted_spot_type();} //note how num_of_spots
is assigned; 
    void fitted_spot_type(){spot_type_list.push_back(LARGE_SPOT_TYPE);}    
};
class Motor: public Vehicle{
public:
    Motor():Vehicle(MOTOR_SPOT_NUM){fitted_spot_type();} 
    void fitted_spot_type(){spot_type_list.push_back(COMPACT_SPOT_TYPE);spot
_type_list.push_back(LARGE_SPOT_TYPE);}    
};
class Bus: public Vehicle{
public:
    Bus():Vehicle(BUS_SPOT_NUM){fitted_spot_type();}
    void fitted_spot_type(){spot_type_list.push_back(LARGE_SPOT_TYPE);}    

};

class ParkingSpot{
public: 
    SpotType type; 
    int floor;
    int row;
    int column;
    bool is_avaiable; 
};
class ParkingLots{
public: 
    ParkingLots(int floor_size0, int row_size0, int col_size0):
      floor_size(floor_size0), row_size(row_size0), col_size(col_size0){init
();}
    ~ParkingLots(){delete [] parking_spot;}
    //vector <ParkingSpot>* parking_spot;
    ParkingSpot* parking_spot;
    bool park(Vehicle& v, int& id);
    bool unpark(Vehicle& v, int id);
    bool have_enough_spots(Vehicle& v, int id); 
private:
    int floor_size, col_size, row_size, capacity; 
    void init();

};
void ParkingLots::init(){
    assert(floor_size>0 && row_size>0 && col_size>0);
    capacity = floor_size * row_size * col_size;
    //parking_spot = new vector<ParkingSpot> [capacity]; 
    parking_spot = new ParkingSpot[capacity]; 
    ParkingSpot* a = NULL; 
    int capacity_of_one_floor = col_size * row_size;
    for (int i = 0; i < capacity; i++){
        a = parking_spot+i;
        
        if (i < 20) a->type = COMPACT_SPOT_TYPE;//assume
        else a->type = LARGE_SPOT_TYPE;
        a->is_avaiable = true;
        a->row = i/col_size;
        a->column = i % col_size;
        a->floor = i /capacity_of_one_floor;
    }
}
bool ParkingLots::park(Vehicle& v, int& id){
    ParkingSpot* a = NULL; 
    for (int i = 0; i < capacity; i++){
        a = parking_spot+i;
        if (a->is_avaiable && have_enough_spots(v, i)){
            id = i;
            for(int j = 0; j < v.num_of_spots; j++){
                a->is_avaiable = false; 
            }
            return true;
        }        
    }
    return false;
}
bool ParkingLots::unpark(Vehicle& v, int id){
    int row = id/col_size;
    int col = id % col_size;
    int floor = id /(col_size * row_size);    
    assert (floor < floor_size && row < row_size  && col< col_size);    
    ParkingSpot* a = NULL;  
    for(int j = 0; j < v.num_of_spots; j++){
        a = parking_spot+id + j;

        if (a->is_avaiable) return false;//no vehicle here at all.
        a->is_avaiable = true; 
    }
    return true;
}
//check whether vehicle v can park starting at spot parking_spot[id]
bool ParkingLots::have_enough_spots(Vehicle& v,int id){
    ParkingSpot* a = NULL;
    int row, floor;
    
    bool res = false;
    for (int i = 0; i < v.num_of_spots; i++){
        a = parking_spot+id + i;
        if (i == 0) {row = a->row;floor = a->floor;}
        if (a->floor != floor || a->row != row) return false; //no space in 
the same floor and row
        if (!v.canPark(a->type)) return false;//spot is not available
    }
    return true;
}
