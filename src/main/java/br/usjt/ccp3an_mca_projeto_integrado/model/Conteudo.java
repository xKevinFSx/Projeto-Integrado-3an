package br.usjt.ccp3an_mca_projeto_integrado.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Conteudo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;
    private String titulo;
    private String descricao;
    @Column(length=1000)
    private String html;
    private Boolean isPublico;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Arquivo arquivo;
    @ManyToMany
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn
    private Categoria categoria;
    @Column(nullable = false, columnDefinition = "int(20) default 0")
    private int feedbackLike;
    @Column(nullable = false, columnDefinition = "int(20) default 0")
    private int feedbackDislike;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Boolean getIsPublico() {
		return isPublico;
	}

	public void setIsPublico(Boolean isPublico) {
		this.isPublico = isPublico;
	}

	public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getLike() {
        return feedbackLike;
    }

    public void setLike(int like) {
        this.feedbackLike = like;
    }

    public int getDislike() {
        return feedbackDislike;
    }

    public void setDislike(int dislike) {
        this.feedbackDislike = dislike;
    }

    public String retornaLista() {
        StringBuilder builder = new StringBuilder();
        for (Tag value : getTags()) {
            builder.append(value);
        }
        return builder.toString();
    }
}
