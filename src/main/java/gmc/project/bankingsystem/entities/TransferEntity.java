package gmc.project.bankingsystem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "transfers")
public class TransferEntity implements Serializable {

	private static final long serialVersionUID = 8839035740103040616L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String id;
	
	@Column(name = "transfer_amount")
	private Long transferAmount;
	
	@OneToOne
	private CustomerEntity transferedFrom;
	
	@OneToOne
	private CustomerEntity transferedTo;

}
