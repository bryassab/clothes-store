import React, { useState } from 'react'
import Grid from '@mui/material/Grid';
import 'bootstrap/dist/css/bootstrap.min.css';
import './newProducts.css'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import axios from 'axios';


export default function NewProducts() {
  const [data, setData] = useState([])
  const [newProduct, setNewProduct] = useState({
    producto: '',
    descripcion: '',
    talla: '',
    color: '',
    cantidad: '',
    precio: '',
  });
  const handleInput = (event) => {
    setNewProduct({
      ...newProduct,
      [event.target.name]: event.target.value
    })
    console.log(newProduct)
  }
  const envio = async (event) => {
    event.preventDefault();
    setNewProduct("")
    event.target.reset();
    await postProducto();
  }

  const postProducto = async () => {
    delete newProduct.id;
    await axios.post('http://localhost:8080/api/producto/save', newProduct)
      .then(nuevo => {
        setData(data.concat(nuevo, data))
      })

  }
  return (
    <div className='base'>
      <Grid container>
        <Grid container item xs={12} sm={6}>
          <div className='nuevoProducto'>
            <h3>Nuevo Producto</h3>
            <div className='formulario'>
              <Form encType='multipart/form-data' onSubmit={envio}>
                <Form.Group className="mb-2" >
                  <Form.Control size="sm" name='producto' type="text" placeholder="Producto" onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-2" >
                  <Form.Control name='descripcion' type="text" placeholder='Descripcion' onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-2" >
                  <Form.Control name='talla' type="text" placeholder="Talla" onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-2" >
                  <Form.Control name='color' type="text" placeholder='Color' onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-3" >
                  <Form.Control name='cantidad' type="number" placeholder="Cantidad" onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-3" >
                  <Form.Control name='precio' type="number" placeholder='Precio' onChange={handleInput} />
                </Form.Group>
                <Button variant="danger">Cancelar</Button>
                <Button variant="primary" type='submit'>Aceptar</Button>
              </Form>
            </div>
          </div>
        </Grid>
        <Grid container item xs={12} sm={6}>
          <div className='actualizarProducto'>
            <h3>Actualizar Producto</h3>
            <div className='formulario'>
              <Form encType='multipart/form-data' onSubmit={envio}>
                <Form.Group className="mb-2" >
                  <Form.Control size="sm" name='producto' type="text" placeholder="Producto" onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-2" >
                  <Form.Control name='descripcion' type="text" placeholder='Descripcion' onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-2" >
                  <Form.Control name='talla' type="text" placeholder="Talla" onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-2" >
                  <Form.Control name='color' type="text" placeholder='Color' onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-3" >
                  <Form.Control name='cantidad' type="number" placeholder="Cantidad" onChange={handleInput} />
                </Form.Group>
                <Form.Group className="mb-3" >
                  <Form.Control name='precio' type="number" placeholder='Precio' onChange={handleInput} />
                </Form.Group>
                <Button variant="danger">Cancelar</Button>
                <Button variant="primary" type='submit'>Aceptar</Button>
              </Form>
            </div>
          </div>


        </Grid>

      </Grid>
    </div >
  )
}
