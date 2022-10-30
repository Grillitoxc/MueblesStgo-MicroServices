import React, { useState } from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import '../assets/css/style.css';

function UploadService() {
    const [file, setFile] = useState();

    const uploadFile = async () => {
        try {
            const formData = new FormData();
            formData.append("file", file);
            const API_URL = "http://localhost:8080/clock";
            await axios.post(API_URL, formData);
        } catch (err) {
            alert(err.message);
        }
    };

    return (
        <div>
            <br />
            <input id='file' type='file' name='file' multiple onChange={(e) => setFile(e.target.files[0])} />
            <label className="upload" htmlFor='file'>
                <span className="material-symbols-outlined" style={{ fontSize: '1.8rem' }}>
                    upload_file
                </span>
                seleccionar archivo
            </label>
            <br />
            <button type="button" className="btn btn-danger btn-circle btn-xl">
                <span className="material-symbols-outlined" style={{ fontSize: '1.8rem' }} onClick={uploadFile}>
                    publish
                </span>
            </button>
        </div>

    );
}

export default UploadService;