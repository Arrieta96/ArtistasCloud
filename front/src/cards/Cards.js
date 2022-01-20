import React, { useEffect, useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faHeart, faRetweet, faShoppingCart} from '@fortawesome/free-solid-svg-icons';
import alkilados from '../assets/img/alkilados.jpeg'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Form'


function Cards(props) {

    const [loading, setLoading] = useState(true);
    const [data, setData] = useState([]);

    useEffect(() => {
        fetch("https://famososartistas.herokuapp.com/api/publicaciones")
        .then(response => response.json())
            // 4. Setting *dogImage* to the image url that we received from the response above
        .then(data =>  {setData(data)
        setLoading(false)})
      },[])

      const handleSubmit = (e) => { 

        console.log( e );
    }
    

    return (

        <> 
                <div class="container">

        <Form onSubmit={ handleSubmit }>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Descripción de la publicación</Form.Label>
                    <Form.Control type="text" placeholder="Texto descripción" /> 
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Link del video</Form.Label>
                    <Form.Control type="text" placeholder="Link del video" /> 
                </Form.Group>   

                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Id del artista</Form.Label>
                    <Form.Control type="text" placeholder="Id del artista" />
                </Form.Group>

 
                <Button variant="secundary" type="submit">
                    Submit
                </Button>
        </Form>
     </div>


        <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>Featured Product</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">Todos</li>
                            <li data-filter=".oranges">Colombia</li>
                            <li data-filter=".fresh-meat">Mexico</li>
                            <li data-filter=".vegetables">Argentina</li>
                            <li data-filter=".fastfood">Peru</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
                
            { loading ? (
                    <div className="alert alert-info text-center">
                        Loading...
                    </div>
                ) :  data.map(item => (

                    <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg">
                            <img src={alkilados}></img>
                            <ul key={item.idPublicacion} class="featured__item__pic__hover">
                                <li><a href="#"><FontAwesomeIcon icon={faHeart}/></a></li>
                                <li><a href="#"><FontAwesomeIcon icon={faRetweet}/></a></li>
                                <li><a href="#"><FontAwesomeIcon icon={faShoppingCart}/></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="#">{item.artista.nombreArtista + ' ' + item.artista.apellidoArtista}</a></h6>
                            <h5>{item.descripcionPublicacion}</h5>
                        </div>
                    </div>
                    </div>
 
      ))}

                


            </div>
        </div>
    </section>

    </>
    );
}

export default Cards;