package pl.agol.dozer.test.entity.collection;

import java.util.List;

import pl.agol.dozer.test.entity.composition.CarFactory.CarRepairInfo;

/**
 * 
 * @author Andrzej Goławski
 *
 */
public class GarageInfo {

	private List<CarRepairInfo> carRepairInfos;

	public List<CarRepairInfo> getCarRepairInfos() {
		return carRepairInfos;
	}

	public void setCarRepairInfos(List<CarRepairInfo> carRepairInfos) {
		this.carRepairInfos = carRepairInfos;
	}
}
