import './styles.css'

function Registration() {

    return (

        <div className="form-container">
            <div className='title-form'>
                <h2>Cadatrar produto</h2>
            </div>
            <form>
                <div>
                    <label htmlFor='name'>Nome</label>
                </div>
                <div>
                    <input type="text" id="name" />
                </div>

                <div>
                    <label htmlFor='name'>Descrição</label>
                </div>
                <div>
                    <input type="text" id="description" />
                </div>

                <div>
                    <label htmlFor='name'>Valor</label>
                </div>
                <div>
                    <input type="number" id="productValue" />
                </div>

                <div>
                    <label htmlFor='name'>Formas de pagamento</label>
                </div>
                <div>
                    <input type="text" id="paymentMethods" />
                </div>

                <button type="submit" value="Submit">
                    <span>
                        Salvar
                    </span>
                </button>

            </form>

        </div>
    )
}

export default Registration;

