package algo;

import java.util.Date;
import java.util.UUID;

public interface AlterDAO {
    public UUID addAlert(Date time);

    public Date getAlert(UUID id);
}
