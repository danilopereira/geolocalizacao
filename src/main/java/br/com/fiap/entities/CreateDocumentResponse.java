package br.com.fiap.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by danilopereira on 29/06/17.
 */
public class CreateDocumentResponse {
    private Boolean ok;
    private String id;
    private String rev;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }
}
