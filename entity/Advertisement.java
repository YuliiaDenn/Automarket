package entity;

public class Advertisement {
private int id;
private int year;
private double price;
private Mark mark;
private Model model;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Mark getMark() {
	return mark;
}
public void setMark(Mark mark) {
	this.mark = mark;
}
public Model getModel() {
	return model;
}
public void setModel(Model model) {
	this.model = model;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((mark == null) ? 0 : mark.hashCode());
	result = prime * result + ((model == null) ? 0 : model.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + year;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Advertisement other = (Advertisement) obj;
	if (id != other.id)
		return false;
	if (mark == null) {
		if (other.mark != null)
			return false;
	} else if (!mark.equals(other.mark))
		return false;
	if (model == null) {
		if (other.model != null)
			return false;
	} else if (!model.equals(other.model))
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	if (year != other.year)
		return false;
	return true;
}
@Override
public String toString() {
	return "Advertisement [id=" + id + ", year=" + year + ", price=" + price + ", mark=" + mark + ", model=" + model
			+ "]";
}



}
