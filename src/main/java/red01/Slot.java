package red01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity 
@IdClass (SlotId.class)
@Table(name = "SLOTS")
public class Slot{
	@Id
	@Column(name = "Room_ID")
	private long id;
	
	@Id
	@Column(name = "slot_ID")
	private int sid;
	
	@Column(name = "free_seats")
	private int seats;
	
	public Slot() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getSeats(Integer roomid, Integer slotid) {
		return seats;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}

	