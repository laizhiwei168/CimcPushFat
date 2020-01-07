package com.cimc.pushfat.manager.po;


public class TaLandYieldPo {
    private String pkLand;

    private String datatime;

    private Double longitude;

    private Double latitude;

    private Double yield;

    private Double weight;
    
    private Double demarcate1;
    
    private Double demarcate2;
    
    private Double simulationValue;
    
    private Integer landType;

    public Double getDemarcate1() {
		return demarcate1;
	}

	public void setDemarcate1(Double demarcate1) {
		this.demarcate1 = demarcate1;
	}

	public Double getDemarcate2() {
		return demarcate2;
	}

	public void setDemarcate2(Double demarcate2) {
		this.demarcate2 = demarcate2;
	}

	public Double getSimulationValue() {
		return simulationValue;
	}

	public void setSimulationValue(Double simulationValue) {
		this.simulationValue = simulationValue;
	}

	public String getPkLand() {
        return pkLand;
    }

    public void setPkLand(String pkLand) {
        this.pkLand = pkLand == null ? null : pkLand.trim();
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getLandType() {
		return landType;
	}

	public void setLandType(Integer landType) {
		this.landType = landType;
	}
}