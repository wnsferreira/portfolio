import './styles.css';
import gitHubLogo from '../images/GitHub.png';

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="navbar-content">
                    <div>
                        <h1>Portfolio Java / React</h1>
                        <a href="https://github.com/wnsferreira/portfolio">
                            <h3>Wellington Ferreira</h3>
                            <img src={ gitHubLogo} width="20" alt='GitHub' />
                        </a>
                    </div>
                    <div className="navbar-login">
                        <p>Login</p>
                        
                    </div>
                </div>
            </nav>
        </header>

    )
}

export default Navbar;