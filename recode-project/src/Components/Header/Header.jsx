import logo from '../../Assets/img/homeico.jpg'
import Navbar from '../Navbar/Navbar';
import './Header.css'
function Header(props) {
    return (
        <header>
            <Navbar img={logo}></Navbar>
        </header>
    );
}

export default Header;