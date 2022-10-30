import Carousel from 'react-bootstrap/Carousel';

function CarouselFadeExample() {
  return (
    <Carousel fade>
      <Carousel.Item interval={5000}>
        <div className="img-1 min-vh-100"></div>
        <Carousel.Caption>
          <h3>Materiales de altísima calidad</h3>
          <p>Seleccionamos la madera de mejor calidad importada al país.</p>
        </Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item interval={5000}>
        <div className="img-2 min-vh-100"></div>
        <Carousel.Caption>
          <h3>Servicio de armado</h3>
          <p>Contáctanos para darte soporte con especialistas de la construcción.</p>
        </Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item interval={5000}>
        <div className="img-3 min-vh-100"></div>
        <Carousel.Caption>
          <h3>Al alcance de tu bolsillo</h3>
          <p>
            Contamos con los mejores precios de la región... ¡El ahorro que estabas esperando!
          </p>
        </Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item interval={5000}>
        <div className="img-4 min-vh-100"></div>
        <Carousel.Caption>
          <h3>Personaliza tus muebles</h3>
          <p>
            Contamos con un sistema de personalización online para que armes tus propios muebles.
          </p>
        </Carousel.Caption>
      </Carousel.Item>

      <Carousel.Item interval={5000}>
        <div className="img-5 min-vh-100"></div>
        <Carousel.Caption>
          <h3>Servicios 24/7</h3>
          <p>
            Compra desde cualquier lugar, a la hora que sea, nuestro servicio técnico de 24 horas siempre estará disponible para ti.
          </p>
        </Carousel.Caption>
      </Carousel.Item>

    </Carousel>
  );
}

export default CarouselFadeExample;