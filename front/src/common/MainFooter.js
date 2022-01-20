import React from 'react';
import payments from '../assets/img/payment-item.png'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faHeart} from '@fortawesome/free-solid-svg-icons';

function MainFooter(props) {
    return (
        <footer className="footer spad">
        <div className="container">
            <div className="row">
                <div className="col-lg-3 col-md-6 col-sm-6">
                    <div className="footer__about">
                        <div className="footer__about__logo">
                            <a href="./index.html"><img src="img/logo.png" alt=""/></a>
                        </div>
                        <ul>
                            <li>Direccion: 560 Av Benavides - Miraflores</li>
                            <li>Telefono: +57 945 354 435</li>
                            <li>Email: hello@artistas.com</li>
                        </ul>
                    </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div className="footer__widget">
                        <h6></h6>
                        <ul>
                            <li><a href="#">Nosotros</a></li>
                            <li><a href="#">Comunidad de Artistas</a></li>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#">Trabaja con nosotros</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Preguntas Frecuentes</a></li>
                            <li><a href="#">Términos y Condiciones</a></li>
                            <li><a href="#">Política y Privacidad</a></li>
                            <li><a href="#">Política de Reembolso</a></li>
                        </ul>
                    </div>
                </div>
                <div className="col-lg-4 col-md-12">
                    <div className="footer__widget">
                        <h6>Únete a nuestra comunidad de artistas</h6>
                        <p>Genera ingresos através de comunidad que buscan buena musica.</p>
                        <form action="#">
                            <input type="text" placeholder="Ingresa tu email"/>
                            <button type="submit" className="site-btn">Suscribete</button>
                        </form>
                        <div className="footer__widget__social">
                            <a href="#"><i className="fa fa-facebook"></i></a>
                            <a href="#"><i className="fa fa-instagram"></i></a>
                            <a href="#"><i className="fa fa-twitter"></i></a>
                            <a href="#"><i className="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div className="row">
                <div className="col-lg-12">
                    <div className="footer__copyright">
                    <div class="footer__copyright__text"><p>
                        Copyright &copy; 2002 Todos los derechos reservados | Este proyecto a sido desarrollado <FontAwesomeIcon icon={faHeart} /> por <a href="#" target="_blank">GRUPO ISIL</a></p></div>
                        <div class="footer__copyright__payment"><img src={payments} alt=""/></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    );
}

export default MainFooter;