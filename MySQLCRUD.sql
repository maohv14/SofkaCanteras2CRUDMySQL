REATE SCHEMA IF NOT EXISTS contact DEFAULT CHARACTER SET utf8 ;
USE contact ;

-- -----------------------------------------------------
-- Table `mydb`.`con_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS con_list (
  contact_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  phone_number VARCHAR(14) NOT NULL,
  email VARCHAR(60) NOT NULL,
  born_at DATE NOT NULL,
  delete_at DATETIME NULL,
  PRIMARY KEY (contact_id))
ENGINE = InnoDB;