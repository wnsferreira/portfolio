import './styles.css';

function Navbar(){
    return(
       <header>
            <nav className="container">
                <div className="navbar-content">
                    <h1>Seja bem vindo ao meu Portfolio!</h1>
                    <div className="navbar-login">
                        <p>Login</p>
                    </div>                   
                </div>
            </nav>
       </header>

    )
}

export default Navbar;