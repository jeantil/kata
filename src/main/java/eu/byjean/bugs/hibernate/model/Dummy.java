package eu.byjean.bugs.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="dummies",schema="TEST")
public class Dummy  {
		@Id
		@Generated(GenerationTime.INSERT)
		private long id; 
		
		@Column(name="name")
		private String name;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		} 
		
}
