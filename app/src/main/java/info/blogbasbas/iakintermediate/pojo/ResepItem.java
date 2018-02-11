package info.blogbasbas.iakintermediate.pojo;


import com.google.gson.annotations.SerializedName;


public class ResepItem{

	@SerializedName("gambar1")
	private String gambar1;

	@SerializedName("nama_resep1")
	private String namaResep1;

	@SerializedName("detail1")
	private String detail1;

	@SerializedName("id_resep1")
	private String idResep1;

	public void setGambar1(String gambar1){
		this.gambar1 = gambar1;
	}

	public String getGambar1(){
		return gambar1;
	}

	public void setNamaResep1(String namaResep1){
		this.namaResep1 = namaResep1;
	}

	public String getNamaResep1(){
		return namaResep1;
	}

	public void setDetail1(String detail1){
		this.detail1 = detail1;
	}

	public String getDetail1(){
		return detail1;
	}

	public void setIdResep1(String idResep1){
		this.idResep1 = idResep1;
	}

	public String getIdResep1(){
		return idResep1;
	}

	@Override
 	public String toString(){
		return 
			"ResepItem{" + 
			"gambar1 = '" + gambar1 + '\'' + 
			",nama_resep1 = '" + namaResep1 + '\'' + 
			",detail1 = '" + detail1 + '\'' + 
			",id_resep1 = '" + idResep1 + '\'' + 
			"}";
		}
}