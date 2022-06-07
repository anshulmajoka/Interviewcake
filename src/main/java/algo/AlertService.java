package algo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class AlertService {
    private AlterDAO alterDAO;
    public AlertService(AlterDAO alterDAO) {
        this.alterDAO = alterDAO;
    }

    private final MapAlertDAO storage = new MapAlertDAO();
		
    public UUID raiseAlert() {
        return alterDAO.addAlert(new Date());
    }
	
    public Date getAlertTime(UUID id) {
        return alterDAO.getAlert(id);
    }	
}

