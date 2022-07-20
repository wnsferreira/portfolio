import './styles.css'

function Registration() {

    return (

        <div className="form-container">
            <h2>Cadatrar produto</h2>
            <form>

                <label htmlFor='name'>Nome</label>
                <input type="text" id="name" />

                <label htmlFor='name'>Descrição</label>
                <input type="text" id="description" />

                <label htmlFor='name'>Valor</label>
                <input type="number" id="productValue" />


                <label htmlFor='name'>Formas de pagamento</label>
                <input type="text" id="paymentMethods" />

                <button type="submit" value="Submit"/>
            </form>
        </div>
    )
}

export default Registration;

// private Integer id;
// private String name;
// private Integer quantityStock;
// private Integer costValue;
// private Integer saleValue;
// private Data dateRegister;
// private String note;