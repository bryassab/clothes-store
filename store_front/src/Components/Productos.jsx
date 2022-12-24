import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Table from 'react-bootstrap/Table';


export default function Productos() {
    const [data, setData] = useState([])

    const peticionGet = async () => {
        await axios.get(`http://localhost:8080/api/producto/all`)
            .then(datos => {
                setData(datos.data)
                console.log(datos.data)
            })
    }
    useEffect(() => {
        peticionGet();
    }, [])
    return (
        <Table  >
            <tbody>
                {data.map((Celda, index) => (
                    <>
                        <td>{Celda.producto}</td>
                        <td>{Celda.cantidad}</td>
                        <td>{Celda.precio}</td>
                        <td>{Celda.color}</td>
                        <td>{Celda.talla}</td>
                    </>
                ))}
            </tbody>
        </Table>
    )
}
