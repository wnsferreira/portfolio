import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./pages/Navbar";
import Registration from "./pages/Registration"

function App() {
  return (
    <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path="/registration" element={<Registration />}/>       
      
      </Routes>
    </BrowserRouter>
   
  );
}

export default App;
