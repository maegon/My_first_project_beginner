//package org.example.dao;
//
//public class MyPlay extends Dao {
//    public static final int BUFFER_SIZE = 44100000;
//    private Decoder decoder;
//    private AudioDevice out;
//    private ArrayList<Sample> samples;
//    private short[][] musicbuffers;
//    private int size;
//
//    public MyPlayer(String path) {
//        Open(path);
//    }
//
//    public boolean IsInvalid() {
//        return (decoder == null || out == null || samples == null || !out.isOpen());
//    }
//    public boolean Open(String path) {
//        Close();
//        try {
//            decoder = new Decoder();
//            out = FactoryRegistry.systemRegistry().createAudioDevice();
//            samples = new ArrayList<Sample>(BUFFER_SIZE);
//            size = 0;
//            out.open(decoder);
//            GetSamples(path);
//            musicbuffers = GetMusicBuffers();
//        } catch(JavaLayerException e) {
//            decoder = null;
//            out = null;
//            return false;
//        }
//        return true;
//    }
//
//    public void Close() {
//        if((out != null) && !out.isOpen())
//            out.close();
//        size = 0;
//        samples = null;
//        out = null;
//        decoder = null;
//    }
//
//    protected boolean GetSamples(String path) {
//        if(IsInvalid())
//            return false;
//        try {
//            Header header;
//            SampleBuffer sb;
//            FileInputStream in = new FileInputStream(path);
//            Bitstream bitstream = new Bitstream(in);
//            if((header = bitstream.readFrame()) == null)
//                return false;
//            while(size < BUFFER_SIZE && header != null) {
//                sb = (SampleBuffer)decoder.decodeFrame(header, bitstream);
//                samples.add(new Sample(sb.getBuffer(), sb.getBufferLength()));
//                size++;
//                bitstream.closeFrame();
//                header = bitstream.readFrame();
//            }
//        } catch(FileNotFoundException e) {
//            return false;
//        } catch(BitstreamException e) {
//            return false;
//        } catch(DecoderException e) {
//            return false;
//        }
//        return true;
//    }
//
//    public void Play() {
//        if(IsInvalid())
//            return;
//        try {
//            for(int i=0; i < size; i++) {
//                short[] buffers = musicbuffers[i];
//                out.write(buffers, 0, samples.get(i).GetSize());
//            }
//            out.flush();
//        } catch(JavaLayerException e) { }
//    }
//}
