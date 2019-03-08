package hello.modelo;


public class ListCreateRequest {
    private Long idAccount;
    private Long idSerie;
    private double rank;
    private Boolean favorito;
    private Boolean visto;
    private Boolean porVer;

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    public Boolean getPorVer() {
        return porVer;
    }

    public void setPorVer(Boolean porVer) {
        this.porVer = porVer;
    }
}
