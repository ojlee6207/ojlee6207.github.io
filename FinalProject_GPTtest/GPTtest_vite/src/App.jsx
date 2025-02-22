import { useState, useRef } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
import GptTest from './GPTmodal/GptTest';
import './App.css'

function App() {
  const [modal, setModal] = useState(false);
  const modalBackground = useRef();

  return (
    <>
      <div>
        <button onClick={() => setModal(true)}>OpenModal</button>
        {
          modal && <div className="modal-overlay" ref={modalBackground}
          onClick={e => {if(e.target === modalBackground.current){
            setModal(false);
          }}}>
            <GptTest />
         </div>
        }
      </div>
    </>
  )
}

export default App;
