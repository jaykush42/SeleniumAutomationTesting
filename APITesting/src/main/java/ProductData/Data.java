package ProductData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    private int year;
    private double price;

    @JsonProperty("CPU model")
    private String cpuModel;

    @JsonProperty("Hard disk size")
    private String hardDiskSize;

//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getCpuModel() {
//        return cpuModel;
//    }
//
//    public void setCpuModel(String cpuModel) {
//        this.cpuModel = cpuModel;
//    }
//
//    public String getHardDiskSize() {
//        return hardDiskSize;
//    }
//
//    public void setHardDiskSize(String hardDiskSize) {
//        this.hardDiskSize = hardDiskSize;
//    }
}
