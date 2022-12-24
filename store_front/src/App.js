import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import NewProducts from './Components/NewProducts'
import Navvbar from './Components/Navbar';
import Productos from './Components/Productos';

function App() {
  return (
    <>
      <Router>
        <Navvbar />
        <Routes>
          <Route path='/' element={<Productos />} />
          <Route index element={<Productos />} />
          <Route path='/productos' element={<Productos />} />
          <Route path='/registro' element={<NewProducts />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
