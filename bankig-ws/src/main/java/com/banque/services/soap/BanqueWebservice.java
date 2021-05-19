package com.banque.services.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;
import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.model.Transaction;

@WebService(name = "BanqueWebservice", targetNamespace = "http://soap.services.banque.com")
@XmlSeeAlso(AuthenticationHeader.class)
public interface BanqueWebservice {

    @WebMethod(operationName = "comptes", exclude = false)
    public abstract List<Compte> comptes(@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "clients", exclude = false)
    public abstract List<Client> clients(@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "virement", exclude = false)
    public abstract void virement(@WebParam(name = "numeroDebit") @XmlElement(required = true) String numeroDebit, @WebParam(name = "numeroCredit")@XmlElement(required = true)String numeroCredit, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "retrait", exclude = false)
    public abstract double retrait(@WebParam(name = "numeroRetrait")@XmlElement(required = true)String numeroRetrait, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description, @WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "depot", exclude = false)
    public abstract void depot(@WebParam(name = "numeroDepot")@XmlElement(required = true)String numeroDepot, @WebParam(name = "montant")@XmlElement(required = true)double montant, @WebParam(name = "description")String description,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "balance", exclude = false)
    public abstract double balance(@WebParam(name = "numeroCompte")@XmlElement(required = true)String numeroCompte,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);

    @WebMethod(operationName = "historique", exclude = false)
    public abstract List<Transaction> historique(@WebParam(name = "numeroCompte")@XmlElement(required = true)String  numeroCompte,@WebParam(header = true,name = "AuthHeader")AuthenticationHeader authenticationHeader);
}
