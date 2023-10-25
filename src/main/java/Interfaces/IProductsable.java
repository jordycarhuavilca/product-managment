package Interfaces;

import java.util.List;

import model.TblProductocl2;

public interface IProductsable {
	public void RegistrarProduct(TblProductocl2 tblProduc);
	public List<TblProductocl2>listarProducts();
}
