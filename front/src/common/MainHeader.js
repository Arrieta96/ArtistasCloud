import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCoffee, faHeart, faShoppingCart, faUser, faEnvelope} from '@fortawesome/free-solid-svg-icons';
import language from '../assets/img/language.png'


function MainHeader(props) {
    return (
        <header className="header">
        <div className="header__top">
            <div className="container">
                <div className="row">
                    <div className="col-lg-6 col-md-6">
                        <div className="header__top__left">
                            <ul>
                                <li><FontAwesomeIcon icon={faEnvelope} /> hello@artistas.com</li>
                                <li>Encuentra artistas desde S/.100.00 soles</li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-6 col-md-6">
                        <div className="header__top__right">
                            <div className="header__top__right__social">
                                <a href="#"><FontAwesomeIcon icon={faCoffee}/></a>
                                <a href="#"><i className="fa fa-twitter"></i></a>
                                <a href="#"><i className="fa fa-linkedin"></i></a>
                                <a href="#"><i className="fa fa-pinterest-p"></i></a>
                            </div>
                            <div className="header__top__right__language">
                                <img src={language} alt=""/>
                                <div>English</div>
                                <span className="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Spanis</a></li>
                                    <li><a href="#">English</a></li>
                                </ul>
                            </div>
                            <div className="header__top__right__auth">
                                <a href="#"><FontAwesomeIcon icon={faUser} /> Login</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div className="container">
            <div className="row">
                <div className="col-lg-3">
                    <div className="header__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""/></a>
                    </div>
                </div>
                <div className="col-lg-6">
                    <nav className="header__menu">
                        <ul>
                            <li className="active"><a href="./salsa.html">Salsa</a></li>
                            <li><a href="./rock.html">Rock</a></li>
                            <li><a href="./cumbia.html">Cumbia</a></li>
                            <li><a href="./merengue.html">Merengue</a></li>
                            <li><a href="./mariachis.html">Mariachis</a></li>
                        </ul>
                    </nav>
                </div>
                <div className="col-lg-3">
                    <div className="header__cart">
                        <ul>
                            <li><a href="#"><FontAwesomeIcon icon={faHeart} /><span>1</span></a></li>
                            <li><a href="#"><FontAwesomeIcon icon={faShoppingCart} /><span>3</span></a></li>
                        </ul>
                        <div className="header__cart__price">item: <span>$150.00</span></div>
                    </div>
                </div>
            </div>
            <div className="humberger__open">
                <i className="fa fa-bars"></i>
            </div>
        </div>
    </header>
    );
}

export default MainHeader;